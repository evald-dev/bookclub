<script setup>
import { computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import {globalAppName} from '../store'

const router = useRouter()
const route = useRoute()

const search = computed({
  get() {
    return route.query.search ?? ''
  },
  set(search) {
    router.replace({ query: { search } })
  }
})
</script>
<template>
  <div data-theme="retro" class="flex bg-gradient-to-br  min-h-screen">
<fieldset class="m-auto fieldset bg-base-200 border-base-300 rounded-box w-xs border p-4">
  <legend class="fieldset-legend">Login</legend>

  <label class="label">Email</label>
  <input type="email" class="input" placeholder="Email" />

  <label class="label">Password</label>
  <input type="password" class="input" placeholder="Password" />
  <p>Don't have an acoount? <a class="link"><RouterLink to="/register">Register</RouterLink></a></p>
  <button class="btn btn-neutral mt-4">Login</button>
</fieldset>
</div>
</template>