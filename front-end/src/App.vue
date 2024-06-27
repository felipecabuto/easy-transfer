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
/* Adicione estilos se necessário */
</style>
