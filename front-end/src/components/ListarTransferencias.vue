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
  