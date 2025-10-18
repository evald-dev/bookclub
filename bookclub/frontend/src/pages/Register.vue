

<script setup>
import {globalAppName} from '../store.js'
import { ref } from 'vue'
const AppName = ref("Knigoeb")
</script>

<template>
  <div class="flex bg-gradient-to-br  min-h-screen">
<fieldset class="m-auto fieldset bg-base-200 border-base-300 rounded-box w-xs border p-4">
  <legend class="fieldset-legend">Register</legend>

  <label class="label">Email</label>
  <input type="email" class="input" placeholder="Email" />

  <label class="label">Password</label>
  <input type="password" class="input" placeholder="Password" />
  <button class="btn btn-neutral mt-4">Login</button>
</fieldset>
</div>
</template>