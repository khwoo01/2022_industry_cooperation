<template>
  <div class="companies">
    <!-- 기존 게시판 코드 -->
    <div>
       <b-container fluid>
         <!-- 게시판 헤더 -->
         <b-row style="padding:10px;">
           <!-- 게시판 제목 -->
           <b-col md="9">
             <h2 align="left">고객사 목록</h2>
           </b-col>
           <!-- 검색창 -->
           <b-col md="3">
             <b-input-group size="sm">
               <b-form-input
                id="filter-input"
                v-model="filter"
                type="search"
                placeholder="기업명/HR담당자/업종/규모"></b-form-input>
             </b-input-group>
           </b-col>
          </b-row>
         <!-- 고객사 목록 table -->
          <b-row>
             <b-table hover :items="users" :filter="filter" :fields="fields"></b-table>
             <!-- <b-table-simple>
              <colgroup>
                <col span="1" style="width=5%">
                <col span="1" style="width=45%">
                <col span="1" style="width=15%">
                <col span="1" style="width=15%">
                <col span="1" style="width=15%">
                <col span="1" style="width=25%">
              </colgroup>
              <b-thead>
                <b-th>No.</b-th>
                <b-th>기업명</b-th>
                <b-th>업종</b-th>
                <b-th>규모</b-th>
                <b-th>HR담당자</b-th>
                <b-th>E-mail</b-th>
              </b-thead>
              <b-tbody>
                <b-tr v-for="user in users" :key="user.co_no">
                  <b-td>{{user.co_no}}</b-td>
                  <b-td>{{user.company}}</b-td>
                  <b-td>{{user.categoryID}}</b-td>
                  <b-td>{{user.sizeID}}</b-td>
                  <b-td>{{user.hr}}</b-td>
                  <b-td>{{user.co_EMAIL}}</b-td>
                </b-tr>
              </b-tbody>
            </b-table-simple> -->
          </b-row>
       </b-container>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: 'Companies',
  data(){
    return{
      users:[],
      fields:[
        {key:'co_NO', label:'No.'},
        {key:'company', label:'기업명'},
        {key:'co_CATEGORY', label:'분야'},
        {key:'co_SIZE', label:'기업규모'},
        {key:'hr', label:'HR담당자'},
        {key:'co_EMAIL', label:'E-mail'}
      ],
      filter: ''
    }
  },
  methods:{
    retrieveUsers(){
      http
        .get("/comp-list")
        .then(response=>{
          this.users = response.data;
          console.log(response.data);
        })
        .catch(e=>{
          console.log(e);
        })
    },
  },
  mounted(){
    this.retrieveUsers();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  padding: 30px
}
</style>