<script setup lang="ts">
import { ref } from 'vue'
import InputText from 'primevue/inputtext'
import FloatLabel from 'primevue/floatlabel'

import Checkbox from 'primevue/checkbox'
import Select from 'primevue/select'

// let profiles:string[] = await sendGetRequest("get_profiles", {})

const segments = ['Малый бизнес', 'Средний бизнес', 'Крупный бизнес']

const params: Record<string, any> = ref({
  clientId: 'client', // ИД пользователя
  organizationId: 'organization', // ИД организациии
  segment: 'value', // Сегмент организации: "Малый бизнес", "Средний бизнес", "Крупный бизнес"
  role: 'value', // Роль уполномоченного лица: "ЕИО", "Сотрудник"
  organizations: 3, // Общее количество организаций у уполномоченного лица: 1..300
  currentMethod: 'method', // Действующий способ подписания."SMS", "PayControl", "КЭП на токене", "КЭП в приложении"
  mobileApp: true, // Наличие мобильного приложения
  signatures: {
    // Подписанные ранее типы документов
    common: {
      mobile: 3, // Количество подписанных базовых документов в мобайле
      web: 10, // Количество подписанных базовых документов в вебе
    },
    special: {
      mobile: 5, // Количество подписанных документов особой важности в мобайле
      web: 6, // Количество подписанных документов особой важности в вебе
    },
  },
  availableMethods: ['method1', 'method2'], // Уже подключенные способы подписания."SMS", "PayControl", "КЭП на токене", "КЭП в приложении"
  claims: 0, // Наличие обращений в банк по причине проблем с использованием СМС
})
</script>

<template>
  <div>
    <h1>Задайте имя и параметры нового пользователя</h1>
    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.clientId" />
      <label for="on_label">clientId</label>
    </FloatLabel>

    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.organizationId" />
      <label for="on_label">organizationId</label>
    </FloatLabel>

    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.segment" />
      <label for="on_label">segment</label>
    </FloatLabel>

    <div>
      <Select
        v-model="params.segment"
        :options="segments"
        optionLabel="name"
        placeholder="segment"
      />
    </div>

    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.role" />
      <label for="on_label">role</label>
    </FloatLabel>

    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.organizations" />
      <label for="on_label">organizations</label>
    </FloatLabel>

    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.currentMethod" />
      <label for="on_label">currentMethod</label>
    </FloatLabel>

    <div>
      <Checkbox v-model="params.mobileApp" inputId="mobileApp" />
      <label for="mobileApp">using mobileApp</label>
    </div>

    <FloatLabel variant="on">
      <InputText id="on_label" v-model="params.mobileApp" />
      <label for="on_label">mobileApp</label>
    </FloatLabel>

    <Button
      class="btn"
      severity="contrast"
      label="Назад"
      @click="$emit('step-back', 'document_type')"
    />
  </div>
</template>

<style scoped></style>
