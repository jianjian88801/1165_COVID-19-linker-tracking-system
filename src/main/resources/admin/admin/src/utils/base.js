const base = {
    get() {
        return {
            url : "http://localhost:8080/jiechuzhe/",
            name: "jiechuzhe",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jiechuzhe/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "新冠病毒密接者跟踪系统"
        } 
    }
}
export default base
