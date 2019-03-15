package com.yo.photo;


import com.yo.photo.entity.TKDepartment;
import com.yo.photo.entity.TKUserDepartment;
import com.yo.photo.repository.DepartmentRepository;
import com.yo.photo.repository.PhotoGroupRepository;
import com.yo.photo.repository.UserDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserDepartmentRepository userDepartmentRepository;

    @Autowired
    PhotoGroupRepository photoGroupRepository;

    public List<TKDepartment> getDepartments(Long kdgtId) {
        List<TKDepartment> departmentList = departmentRepository.findAllByKdgtTabId(kdgtId);
        return departmentList;
    }

    public List<TKUserDepartment> getUser(long departmentId) {
        return userDepartmentRepository.findAllByDepartmentTabId(departmentId);
    }
}
