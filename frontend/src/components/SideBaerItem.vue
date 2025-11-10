<script setup>
// 1. Definiere die "Props", die von außen kommen
// Wir erwarten ein 'label', das ein String ist.
defineProps({
  label: {
    type: String,
    required: true
  }
})

// 2. Definiere die "Events", die diese Komponente aussendet
// Das erlaubt dem Parent, auf @click zu hören.
defineEmits(['click'])
</script>

<template>
    <button
      class="is-drawer-close:tooltip is-drawer-close:tooltip-right"
      :data-tip="label"       @click="$emit('click')" >
      
      <slot name="icon"></slot>

      <span class="is-drawer-close:hidden">{{ label }}</span>

    </button>
</template>