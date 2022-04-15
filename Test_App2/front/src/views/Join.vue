<template>
    <div class="join">
    <b-card>
        <b-row align-h="center" style="padding:30px;">
            <b-col>
                <b-button variant="light" href="/">Matching Platform</b-button>
            </b-col>
        </b-row>
        
        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button size="lg" variant="primary" href="/#/join-indv">일반회원가입</b-button>
            </b-col>
        </b-row>
        
        <b-row align-h="center" style="padding:10px;">
            <b-col>
                <b-button size="lg" variant="primary" href="/#/join-comp">기업회원가입</b-button>  
            </b-col>
        </b-row>
    </b-card>
  </div>
</template>

<script>
export default {
};
</script>

<style>
.join{
  position:absolute;
  top: 380px;
  left: 50%;
  width: 400px;
  margin: -150px 0 0 -200px;
}
</style>