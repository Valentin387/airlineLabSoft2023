<template>
    <div v-if="showError" class="error-modal">
      <div class="error-content">
        <p>{{ errorMessage }}</p>
        <button @click="closeModal" class="close-button">Cerrar</button>
      </div>
    </div>
</template>

<style scoped>
.error-modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* Fondo oscurecido */
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000; /* Asegúrate de que esté en la parte superior */
}

.error-content {
  background-color: white;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  text-align: center;
  color: black;
}

.close-button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: #0B97F4;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.close-button:hover {
  background-color: #0D629B;
}
</style>
  
<script>
  export default {
    props: {
      showError: Boolean,
      errorMessage: String,
    },
    methods: {
      closeModal() {
        this.$emit("close");
      },
    },
  };
</script>
  