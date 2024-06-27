<template>
  <div>
    <h1>Agendar Transferência</h1>
    <form @submit.prevent="agendarTransferencia">
      <label>Conta de Origem:</label>
      <input v-model="transferencia.contaOrigem" required />

      <label>Conta de Destino:</label>
      <input v-model="transferencia.contaDestino" required />

      <label>Valor:</label>
      <input type="number" v-model="transferencia.valor" required />

      <label>Data da Transferência:</label>
      <input type="date" v-model="transferencia.dataTransferencia" required />

      <button type="submit">Agendar</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      transferencia: {
        contaOrigem: '',
        contaDestino: '',
        valor: '',
        dataTransferencia: ''
      }
    };
  },
  methods: {
    agendarTransferencia() {
      // eslint-disable-next-line no-unused-vars
      axios.post('/api/transferencias', this.transferencia)
        .then(response => {  // eslint-disable-line no-unused-vars
          alert('Transferência agendada com sucesso!');
        })
        .catch(error => {
          alert('Erro ao agendar transferência: ' + error.response.data.message);
        });
    }
  }
};
</script>
