<template>
    <div v-if="showSpinner" class="spinner-overlay">
     <div class="spinner"></div>
    </div>
</template>

<script>
    export default {
        props: {
        showSpinner: {
            type: Boolean,
            default: false,
        },
        },
    };
</script>

<style lang="scss" scoped>


    
    .spinner-overlay {
        position: fixed;  // permite colocarlo en coordenadas exactas, sin que se vea afectado por scroll 
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        display: flex;
        justify-content: center;
        align-items: center;
        z-index: 999;
    }

    .spinner {
        border: 4px solid rgba(255, 255, 255, 0.3);
        border-top: 4px solid #3498db; /* Change color as needed */
        border-radius: 50%;
        width: 40px;
        height: 40px;
        animation: spin 2s linear infinite;
    }

    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }

</style>