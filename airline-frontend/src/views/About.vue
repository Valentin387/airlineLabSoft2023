<template> 
    <main class="About-page"> 
        <h1>About</h1>
        <p>Esta es la pagina sobre nosotros</p>
    </main>
    <!------------------------------------------------FOOTER------------------------------------------->
    <Footer></Footer>

</template>


<script>
// Import the Footer component
import Footer from '@/components/footer.vue';

export default {
  components: {
    Footer,
  },
};
</script>