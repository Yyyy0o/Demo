package com.yo.photo.entity;

import java.util.List;

/**
 *  七牛 添加 人像库
 */
public class NewBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uri : http://xx.com/xxx
         * attribute : {"id":"<id>","name":"<name>","mode":"<mode>","desc":"<additional information>","reject_bad_face":false}
         */

        private String uri;
        private AttributeBean attribute;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public AttributeBean getAttribute() {
            return attribute;
        }

        public void setAttribute(AttributeBean attribute) {
            this.attribute = attribute;
        }

        public static class AttributeBean {
            /**
             * id : <id>
             * name : <name>
             * mode : <mode>
             * desc : <additional information>
             * reject_bad_face : false
             */

            private String id;
            private String name;
            private String mode;
            private String desc;
            private boolean reject_bad_face;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMode() {
                return mode;
            }

            public void setMode(String mode) {
                this.mode = mode;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public boolean isReject_bad_face() {
                return reject_bad_face;
            }

            public void setReject_bad_face(boolean reject_bad_face) {
                this.reject_bad_face = reject_bad_face;
            }
        }
    }
}
