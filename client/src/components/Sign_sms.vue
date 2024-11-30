<script setup lang="ts">
import Button from 'primevue/button'
import InputOtp from 'primevue/inputotp'
import { ref } from 'vue'

const { profile, document_type } = defineProps(['profile', 'document_type'])

const sms_code = ref('')
</script>

<template>
  <div id="div">
    <h1>
      Введите код из смс. Тип документа: <span>{{ document_type }}</span> Профиль:
      <span>{{ profile }}</span>
    </h1>

    <InputOtp class="sms_code" v-model="sms_code" />
    <Button class="btn" label="Отправить" @click="$emit('check-sms-sign', sms_code)" />

    <Button class="btn" severity="contrast" label="Назад" @click="$emit('step-back', 'sign_sms')" />
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
