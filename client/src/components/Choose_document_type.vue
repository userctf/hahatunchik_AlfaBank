<script setup lang="ts">
import Button from 'primevue/button'

const { profile } = defineProps(['profile'])

const document_types: string[] = ['Обычный', 'Специальный']
</script>

<template>
  <div>
    <h1>Выберите тип документа для подписи. Профиль: {{ profile }}</h1>
    <Button
      class="btn"
      v-for="dt in document_types"
      :label="dt"
      @click="$emit('select-document', dt)"
    />

    <Button
      class="btn"
      severity="contrast"
      label="Назад"
      @click="$emit('step-back', 'document_type')"
    />
  </div>
</template>

<style scoped>
h1 {
  margin-bottom: 50px;
}
div {
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
