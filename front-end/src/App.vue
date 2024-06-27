<template>
  <div id="app">
    <AgendarTransferencia />
    <ListarTransferencias />
    <p>Easy Transfer API</p>
  </div>
</template>

<script>
import AgendarTransferencia from './components/AgendarTransferencia.vue';
import ListarTransferencias from './components/ListarTransferencias.vue';

export default {
  name: 'App',
  components: {
    AgendarTransferencia,
    ListarTransferencias
  }
};
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  color: #333;
}
</style>