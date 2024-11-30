<script setup lang="ts">
import Button from 'primevue/button'
import InputText from 'primevue/inputtext'

import { ref } from 'vue'

const { profile, document_type } = defineProps(['profile', 'document_type'])

const passcode = ref('')
</script>

<template>
  <div id="div">
    <h1>
      Введите пин код вашего ключа доступа. Тип документа: <span>{{ document_type }}</span> Профиль:
      <span>{{ profile.clientId }}</span>
    </h1>

    <InputText type="text" class="sms_code" v-model="passcode" />
    <Button class="btn" label="Подписать" @click="$emit('check-sign', passcode)" />

    <Button class="btn" severity="contrast" label="Назад" @click="$emit('step-back', 'sign')" />
  </div>
</template>

<style scoped>
h1 {
  margin-bottom: 50px;
}
h1 span {
  color: var(--main-white);
  background-color: var(--main-red);
  padding: 2px;
}
#div {
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

.sms_code {
  margin: 20px 0;
}
</style>
