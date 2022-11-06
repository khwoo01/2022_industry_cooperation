<template>
  <div class="login">
    
    <b-card title="로그인">        
        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button size="lg" variant="primary" href="/#/login-indv">일반회원 로그인</b-button>
            </b-col>
        </b-row>
        
        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button size="lg" variant="primary" href="/#/login-comp">기업회원 로그인</b-button>  
            </b-col>
        </b-row>

        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button size="lg" variant="primary" href="/#/Manager-log">관리자 로그인</b-button>  
            </b-col>
        </b-row>

        <b-row>
          <b-button variant="link" href="/#/join">회원가입</b-button>
        </b-row>
    </b-card>


  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        id: "",
        pw: "",
      },
    };
  },
};
</script>

<style>
.login {
  position: absolute;
  top: 380px;
  left: 50%;
  width: 400px;
  margin: -150px 0 0 -200px;
}
</style>
