<template>
    <div class="Manager-log">
      <b-form @submit="Manager">
        <b-card title="관리자 로그인">
          <!-- ID -->
          <b-form-group label="ID" label-for="input-id">
            <b-form-input
              id="input-id"
              type="text"
              v-model="form.id"
              placeholder="Enter ID"
              required
            ></b-form-input>
          </b-form-group>
  
          <!-- 비밀번호 -->
          <b-form-group label="Password" label-for="input-pw">
            <b-form-input
              id="input-pw"
              type="password"
              v-model="form.pw"
              placeholder="Enter Password"
              required
            ></b-form-input>
          </b-form-group>
  
          <b-button type="submit" variant="primary"> 로그인 </b-button>
        </b-card>
      </b-form>
    </div>
  </template>
  
  <script>
  import http from "../http-common";
  
  export default {
    name: "Manager",
    data() {
      return {
        form: {
          id: "",
          pw: "",
        },
      };
    },
    methods: {
      Manager() {
        http
          .post("/login", {
            id: this.form.id,
            pw: this.form.pw,
            user_code: 2,
          })
          .then((response) => {
            if (response.data) {
              console.log(response.data);
              alert("로그인 성공");
              this.$router.push({ name: "Home" });
            //  this.$router.go(0);
            } else {
              console.log(response.data);
              alert("로그인 실패..ID/PW를 다시 확인해주세요.");
             // this.$router.go(0);
            }
          })
          .catch((e) => {
            console.log(e);
            alert("로그인 실패..오류 발생..");
            //this.$router.go(0);
          });
      },
    },
  };
  </script>
  
  <style>
  .Manager-log {
    position: absolute;
    top: 380px;
    left: 50%;
    width: 400px;
    margin: -150px 0 0 -200px;
  }
  </style>
  