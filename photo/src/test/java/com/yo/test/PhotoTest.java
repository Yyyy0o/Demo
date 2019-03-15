package com.yo.test;

import com.yo.photo.PhotoApplication;
import com.yo.photo.PhotoService;
import com.yo.photo.entity.TKDepartment;
import com.yo.photo.entity.TKPhotoGroup;
import com.yo.photo.entity.TKPhotoTeacher;
import com.yo.photo.entity.TKUserDepartment;
import com.yo.photo.repository.PhotoGroupRepository;
import com.yo.photo.repository.PhotoTeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhotoApplication.class)
public class PhotoTest {

    @Autowired
    PhotoService photoService;

    @Autowired
    PhotoGroupRepository photoGroupRepository;

    @Autowired
    PhotoTeacherRepository photoTeacherRepository;

    @Test
    public void fun1() {
        Map<Long, List<Long>> departmentMap = new HashMap<>();

        List<TKPhotoGroup> departmentList = photoGroupRepository.findAllByType("department");
        for (TKPhotoGroup t : departmentList) {
            if (departmentMap.containsKey(t.getGroupId())) {
                List<Long> list = departmentMap.get(t.getGroupId());
                list.add(t.getPhotoId());
                departmentMap.put(t.getGroupId(), list);
            } else {
                List<Long> list = new ArrayList<>();
                list.add(t.getPhotoId());
                departmentMap.put(t.getGroupId(), list);
            }
        }


        List<TKPhotoGroup> publicList = photoGroupRepository.findAllByType("public");
        for (TKPhotoGroup t : publicList) {
            List<TKDepartment> departments = photoService.getDepartments(t.getGroupId());

            for (TKDepartment d : departments) {
                if (departmentMap.containsKey(d.getId())) {
                    List<Long> list = departmentMap.get(d.getId());
                    list.add(t.getPhotoId());
                    departmentMap.put(d.getId(), list);
                } else {
                    List<Long> list = new ArrayList<>();
                    list.add(t.getPhotoId());
                    departmentMap.put(d.getId(), list);
                }
            }
        }

        Set<Long> dIds = departmentMap.keySet();
        for (Long id : dIds) {
            List<Long> pIds = departmentMap.get(id);
            List<TKPhotoTeacher> list = new ArrayList<>();
            for (Long photoId : pIds) {
                TKPhotoTeacher entity = new TKPhotoTeacher();
                entity.setPhotoTabId(photoId);
                entity.setCreateTime(new Date());
                list.add(entity);
            }
            List<TKUserDepartment> userList = photoService.getUser(id);
            for (TKUserDepartment user: userList) {
                for (TKPhotoTeacher p: list) {
                    p.setUserTabId(user.getUserTabId());
                }
                photoTeacherRepository.saveAll(list);
            }

        }
    }

}
