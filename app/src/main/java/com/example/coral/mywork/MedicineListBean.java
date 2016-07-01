package com.example.coral.mywork;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MedicineListBean {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"count":2093,"data":[{"drugId":"460","dsName":"盐酸吗啉胍滴眼液\u2014\u2014沧州光明药业","drugType":"0","generalId":"1204225"},{"drugId":"5737","dsName":"倍诺喜\u2014\u2014盐酸奥布卡因滴眼液","drugType":"0","generalId":"1203938"},{"drugId":"12431","dsName":"盐酸奥布卡因滴眼液\u2014\u2014山东博士伦福瑞达制药","drugType":"0","generalId":"1203938"},{"drugId":"2637","dsName":"盐酸氯环利嗪乳膏","drugType":"0","generalId":"1204185"},{"drugId":"2195","dsName":"盐酸三氟哌多片","drugType":"0","generalId":"1204320"},{"drugId":"2337","dsName":"盐酸妥卡尼胶囊","drugType":"0","generalId":"1204361"},{"drugId":"14415","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014天津药业焦作","drugType":"0","generalId":"1204098"},{"drugId":"15705","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014上海现代哈森(商丘)药业","drugType":"0","generalId":"1204098"},{"drugId":"17837","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014上海禾丰制药","drugType":"0","generalId":"1204098"},{"drugId":"18410","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014国药集团容生制药","drugType":"0","generalId":"1204098"}]}
     */

    private int errNum;
    private String errMsg;
    /**
     * count : 2093
     * data : [{"drugId":"460","dsName":"盐酸吗啉胍滴眼液\u2014\u2014沧州光明药业","drugType":"0","generalId":"1204225"},{"drugId":"5737","dsName":"倍诺喜\u2014\u2014盐酸奥布卡因滴眼液","drugType":"0","generalId":"1203938"},{"drugId":"12431","dsName":"盐酸奥布卡因滴眼液\u2014\u2014山东博士伦福瑞达制药","drugType":"0","generalId":"1203938"},{"drugId":"2637","dsName":"盐酸氯环利嗪乳膏","drugType":"0","generalId":"1204185"},{"drugId":"2195","dsName":"盐酸三氟哌多片","drugType":"0","generalId":"1204320"},{"drugId":"2337","dsName":"盐酸妥卡尼胶囊","drugType":"0","generalId":"1204361"},{"drugId":"14415","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014天津药业焦作","drugType":"0","generalId":"1204098"},{"drugId":"15705","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014上海现代哈森(商丘)药业","drugType":"0","generalId":"1204098"},{"drugId":"17837","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014上海禾丰制药","drugType":"0","generalId":"1204098"},{"drugId":"18410","dsName":"盐酸甲氧氯普胺注射液\u2014\u2014国药集团容生制药","drugType":"0","generalId":"1204098"}]
     */

    private RetDataBean retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataBean getRetData() {
        return retData;
    }

    public void setRetData(RetDataBean retData) {
        this.retData = retData;
    }

    public static class RetDataBean {
        private int count;
        /**
         * drugId : 460
         * dsName : 盐酸吗啉胍滴眼液——沧州光明药业
         * drugType : 0
         * generalId : 1204225
         */

        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String drugId;
            private String dsName;
            private String drugType;
            private String generalId;

            public String getDrugId() {
                return drugId;
            }

            public void setDrugId(String drugId) {
                this.drugId = drugId;
            }

            public String getDsName() {
                return dsName;
            }

            public void setDsName(String dsName) {
                this.dsName = dsName;
            }

            public String getDrugType() {
                return drugType;
            }

            public void setDrugType(String drugType) {
                this.drugType = drugType;
            }

            public String getGeneralId() {
                return generalId;
            }

            public void setGeneralId(String generalId) {
                this.generalId = generalId;
            }
        }
    }
}
