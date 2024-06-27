<template>
  <div>
    <h1>Lista de Transferências Agendadas</h1>
    <ul>
      <li v-for="transferencia in transferencias" :key="transferencia.id">
        {{ transferencia.contaOrigem }} -> {{ transferencia.contaDestino }}: {{ transferencia.valor }} em {{ transferencia.dataTransferencia }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      transferencias: []
    };
  },
  created() {
    this.carregarTransferencias();
  },
  methods: {
    carregarTransferencias() {
      axios.get('/api/transferencias')
        .then(response => {
          this.transferencias = response.data;
        })
        .catch(error => {
          console.error('Erro ao carregar transferências: ' + error.response.data.message);
        });
    }
  }
};
</script>

<style scoped>
h2 {
  margin-bottom: 20px;
}

ul {
  text-align: left;
  margin: 0 auto;
  max-width: 600px;
  list-style-type: none;
  padding: 0;
}

li {
  background: #f9f9f9;
  margin: .5em 0;
  padding: .5em;
  border-radius: 3px;
}
</style>