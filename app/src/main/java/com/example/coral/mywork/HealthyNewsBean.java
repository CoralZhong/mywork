package com.example.coral.mywork;

import java.util.List;

/**
 * Created by Administrator on 2016/6/23.
 */
public class HealthyNewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-31 15:15","title":"四部门要求医疗责任未认定前 禁赔钱息事","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img3.cache.netease.com/jiankang/2016/3/31/20160331151504029d8.gif_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0331/15/BJGCR48200380014.html"},{"ctime":"2016-03-31 11:43","title":"农业部新订《复原乳鉴定》 剑指\u201c还原奶\u201d","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img3.cache.netease.com/jiankang/2016/3/31/2016033111395671a97.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0331/11/BJG0LDE100380014.html"},{"ctime":"2016-03-30 19:07","title":"他们要的不是锦旗和鲜花 他们只求最基本的尊重","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img3.cache.netease.com/jiankang/2016/3/30/20160330190807179d0.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0330/19/BJE7LOQ900380014.html"},{"ctime":"2016-03-30 14:23","title":"东西方膳食结构不同 中国人不应忽略饮水中钙的补充","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img3.cache.netease.com/cnews/2016/3/30/20160330143418cbbfa.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0330/14/BJDNF1E000380014.html"},{"ctime":"2016-03-30 14:31","title":"脐带血并非万能 到底要不要存起来？","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img4.cache.netease.com/jiankang/2016/3/30/201603301430201fb1f.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0330/14/BJDNS9JL00380014.html"},{"ctime":"2016-03-29 10:41","title":"浙江破获价值超5000余万元特大假美容药案","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img1.cache.netease.com/jiankang/2016/3/29/201603291037193f4b2_550.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0329/10/BJAOAVRO00380014.html"},{"ctime":"2016-03-28 13:38","title":"\u201c高锰钢\u201d电水壶喝了变傻？专家称是误读","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img1.cache.netease.com/catchpic/4/4D/4DE8CC63CE177D46D2106FF2A87EAE27.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0328/13/BJ8G92SJ0038002S.html"},{"ctime":"2016-03-27 10:39","title":"食药监总局回应疫苗安全问题","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img5.cache.netease.com/jiankang/2016/3/27/201603271039115fdfb.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0327/10/BJ5JE9II00380014.html"},{"ctime":"2016-03-25 13:51","title":"内蒙古查获80吨假盐 如何识别假盐？","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img6.cache.netease.com/jiankang/2016/3/25/201603251353027d133_550.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0325/13/BJ0PK15P0038002Q.html"},{"ctime":"2016-03-25 14:42","title":"\u201c阿法狗\u201d或可帮助人类攻克癌症","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img4.cache.netease.com/jiankang/2016/3/25/201603251440084daef_550.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0325/14/BJ0SGIRK00380014.html"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-03-31 15:15
     * title : 四部门要求医疗责任未认定前 禁赔钱息事
     * description : 网易健康
     * picUrl : http://imgsize.ph.126.net/?imgurl=http://img3.cache.netease.com/jiankang/2016/3/31/20160331151504029d8.gif_150x100x1x85.jpg
     * url : http://jiankang.163.com/16/0331/15/BJGCR48200380014.html
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
