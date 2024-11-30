<script setup lang="ts">
import Button from 'primevue/button'
import { sendPostRequest, sendGetRequest } from './Base.ts'

// let profiles:string[] = await sendGetRequest("get_profiles", {})

const profiles: string[] = ['Настя', 'Олег', 'Джон']
</script>

<template>
  <div>
    <h1>Для тестирования выберите доступного пользователя или создайте нового</h1>
    <Button class="btn" v-for="p in profiles" :label="p" @click="$emit('select-profile', p)" />

    <Button
      class="btn"
      severity="help"
      label="Добавить нового пользователя"
      @click="$emit('add-profile')"
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
