<template>
  <div class="my-page-indv">
    <b-container fluid align="left">
      <!-- 마이페이지 헤더 -->
      <b-row style="padding:10px;">
        <b-col md="12">
          <h2 align="left">채용공고</h2>
        </b-col>
      </b-row>
      <div class="my-page-body">
        <!-- 이름 및 성별 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>제목 :</h5>
          </b-col>
          <b-col md="5">
            <b-card no-body class="text-left" style="padding:5px;">
              {{ job.position }}
            </b-card>
          </b-col>
          <b-col md="2">
            <h5>채용형태 :</h5>
          </b-col>
          <b-col md="3">
            <b-card no-body class="text-left" style="padding:5px;">
              {{job.employ_TYPE}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 출생년도 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>마감일:</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{job.regi_dt}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 이메일 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>E-mail :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{job.position}}
            </b-card>
          </b-col>
        </b-row>
        <!-- 번호 -->
        <b-row style="padding:10px;">
          <b-col md="2">
            <h5>Contact :</h5>
          </b-col>
          <b-col md="10">
            <b-card no-body class="text-left" style="padding:5px;">
              {{job.job}}
            </b-card>
          </b-col>
        </b-row>
     
      </div>
    </b-container>
  </div>
</template>

<script>
import http from "../http-common";


export default { 
  name: "JobDetail",
  props: {
    post_NO: {
    type: Number,
    default: 0
    }
  },
  data(props)
  {
    return{
    job: {
        post_NO: props.post_NO,
        company: "",
        position: "",
        qualify: "",
        employ_TYPE: "",
        regi_DT: "",
    },
    checkInfo: false,
  };
  },
  methods: {
    check(){
      http
        .post("/checkdetail",
         {
        post_NO: this.post_NO,
        company: this.company,
        position: this.position,
        qualify: this.qualify,
        employ_TYPE: this.employ_TYPE,
        regi_DT: this.regi_DT
      })
        .then((response) => {
         if (response.data != -1){ 
         this.checkInfo = true;
         this.callrowdetail();}
        else{
          this.checkInfo = false;
          this.callrowdetail();}
        })
        .catch((e) => {
          console.log(e);
        });
    
    },
    //누른 행의 채용공고 정보를 가져옴
    callrowdetail()
    {  
      console.log(this.post_NO);
      http
        .get("/jobdetail",{params: {post_NO: this.post_NO}})
        .then((response) => {
          if (response.data != -1)
          {
            console.log(response.data);
            this.job = response.data;
          }
        })
        .catch((e) => 
        {
          console.log(e)
        });
    },
  },
  mounted()
  {
    this.check();
  },
};


</script>

<style scoped></style>