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

<style scoped>
h1 {
  margin-bottom: 20px;
}

form {
  text-align: left;
  max-width: 600px;
  margin: 0 auto;
  padding: 1em;
  background: #f9f9f9;
  border-radius: 5px;
}

label {
  font-weight: bold;
  margin-top: 10px;
}

input {
  padding: 8px;
  margin-top: 5px;
  border: 1px solid #CCCCCC;
  border-radius: 3px;
  width: 100%;
  box-sizing: border-box;
}

button {
  padding: 0.7em;
  color: #fff;
  background-color: #089629;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width: 100%;
  font-size: 1em;
}

button:hover {
  background-color: #0eb234;
}
</style>