
<template>
	<div class="app">
   		<!-- <sidebar />   --> 
		
		<barraHorizontal />
		<Home />
		<Login />
		<SignUp />
		<router-view/>

	</div>  
</template>


<script setup>
import barraHorizontal from './components/barraHorizontal.vue'

</script>



	

<!--<script setup>
import Sidebar from './components/Sidebar.vue'
</script>

<style lang="scss">
:root {
	--primary: #7EBEA5;
	--grey: #5CBDDD;
	--dark: #266066;
	--dark-alt: #1C5F83;
	--light: #F3F8FE;
	--sidebar-width: 300px;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Fira sans', sans-serif;
}
//COLOR DE FONDO
//body {
//	background: var(--grey);
//}

button {
	cursor: pointer;
	appearance: none;
	border: none;
	outline: none;
	background: none;
}

.app {
	display: flex;

	main {
		flex: 1 1 0;
		padding: 2rem;

		@media (max-width: 1024px) {
			padding-left: 6rem;
		}
	}
}

</style>
--> 