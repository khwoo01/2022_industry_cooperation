<template>
  <div class="hello">
   <h1>test</h1>
    <!-- navbar(헤더) -->
   <h3 v-for="personal in test2" :key="personal.P_ID">{{personal.NAME}}</h3>
    <p>
      For a guide and recipes on how to configure / customize this project,<br>
      check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.
    </p>
     <!-- navbar(헤더) -->
  </div>

</template>

<script>

export default {
  name: 'HelloWorld',
    data(){
    return{
      personal:[]
    }
},
/**/
methods:{
    retrieveUsers(){
      http
        .get("/list")
        .then(response=>{
          this.personal = response.data;
          console.log(response.data);
        })
        .catch(e=>{
          console.log(e);
        })
    }
  },
  mounted(){
    this.retrieveUsers();
  },
  /**/
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
  padding: 30px
}
</style>