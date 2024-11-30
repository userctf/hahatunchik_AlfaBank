<script setup lang="ts">
import Button from 'primevue/button'

const { sign_methods, profile, document_type } = defineProps([
  'sign_methods',
  'profile',
  'document_type',
])
</script>

<template>
  <div class="div">
    <h1>
      Выберите способ подписи. Мы советуем первый способ. Тип документа:
      <span>{{ document_type }}</span> Профиль: <span>{{ profile }}</span>
    </h1>
    <Button
      class="btn"
      v-for="method in sign_methods"
      :label="method"
      @click="$emit('select-sign-method', method)"
    />

    <Button
      class="btn"
      severity="contrast"
      label="Назад"
      @click="$emit('step-back', 'sign_method')"
    />
  </div>
</template>

<style scoped>
h1 {
  margin-bottom: 50px;
}
.div {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.btn {
  display: block;
  font-size: 2em;
  margin: 20px 0;
  width: 40%;
  padding: 15px 20px;
}

.btn:last-child {
  margin-top: 30px;
}
</style>
