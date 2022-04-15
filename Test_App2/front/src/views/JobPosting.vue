<template>
  <div class="jobposting">
    <!-- 기존 게시판 코드 -->
    <div>
       <b-container fluid>
         <!-- 게시판 헤더 -->
         <b-row style="padding:10px;">
           <!-- 게시판 제목 -->
           <b-col md="6">
             <h2 align="left">채용 공고</h2>
           </b-col>
           <!-- 포지션 DB 등록 버튼(기업회원만 접근 가능) -->
           <b-col md="3">
              <div v-show="user_code == 'qwe'">
                <b-button variant="primary" href="/#/register-position">포지션 DB 등록</b-button>
              </div>
             
           </b-col>
           <!-- 검색창 -->
           <b-col md="3">
             <b-input-group size="sm">
               <b-form-input
                id="filter-input"
                v-model="filter"
                type="search"
                placeholder="기업명/제목/경력조건/채용형태"></b-form-input>
             </b-input-group>
           </b-col>
          </b-row>
         <!-- 고객사 목록 table -->
          <b-row>
             <b-table hover :items="contents" :filter="filter" :fields="fields"></b-table>
          </b-row>
       </b-container>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: 'JobPosting',
  data(){
    return{
      contents:[],
      fields:[
        {key:'post_NO', label:'No.'},
        {key:'company', label:'기업명'},
        {key:'position', label:'공고 제목'},
        {key:'qualify', label:'경력조건'},
        {key:'employ_TYPE', label:'채용형태'},
        {key:'regi_DT', label:'채용마감'}
      ],
      filter: '',
      user_code:'asd'
    }
  },
  methods:{
    retrieveContents(){
      http
        .get("/job-posting")
        .then(response=>{
          this.contents = response.data;
          console.log(response.data);
        })
        .catch(e=>{
          console.log(e);
        })
    },
    checkUserCode(){
      http
        .post("/check-usercode")
        .then(response=>{
          console.log(response.data);
          if(response.data){
            this.user_code = 'qwe'
          }
          else{
            this.user_code = 'asd';
          }
        })
        .catch(e=>{
          console.log(e);
        })
    },
  },
  mounted(){
    this.retrieveContents();
    this.checkUserCode();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  padding: 30px
}
</style>