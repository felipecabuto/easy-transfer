<template>
    <div>
      <h1>Transferências Agendadas</h1>
      <table>
        <thead>
          <tr>
            <th>Conta de Origem</th>
            <th>Conta de Destino</th>
            <th>Valor</th>
            <th>Taxa</th>
            <th>Data de Transferência</th>
            <th>Data de Agendamento</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="transferencia in transferencias" :key="transferencia.id">
            <td>{{ transferencia.contaOrigem }}</td>
            <td>{{ transferencia.contaDestino }}</td>
            <td>{{ transferencia.valor }}</td>
            <td>{{ transferencia.taxa }}</td>
            <td>{{ transferencia.dataTransferencia }}</td>
            <td>{{ transferencia.dataAgendamento }}</td>
          </tr>
        </tbody>
      </table>
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
      this.fetchTransferencias();
    },
    methods: {
      fetchTransferencias() {
        axios.get('http://localhost:8080/transferencias')
          .then(response => {
            this.transferencias = response.data;
          })
          .catch(error => {
            alert('Erro ao buscar transferências: ' + error.response.data.message);
          });
      }
    }
  };
  </script>
  