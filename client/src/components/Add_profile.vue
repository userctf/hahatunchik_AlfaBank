<script setup lang="ts">
import { sendPostRequest } from './Base.ts'
import { ref } from 'vue'
import InputNumber from 'primevue/inputnumber'
import Button from 'primevue/button'
import FloatLabel from 'primevue/floatlabel'

import Checkbox from 'primevue/checkbox'
import Select from 'primevue/select'

import SelectButton from 'primevue/selectbutton'

const segments = ref(['Малый бизнес', 'Средний бизнес', 'Крупный бизнес'])
const roles = ref(['ЕИО', 'Сотрудник'])
const methods = ref(['SMS', 'PayControl', 'КЭП на токене', 'КЭП в приложении'])

const params: Record<string, any> = ref({
  clientId: undefined, // ИД пользователя
  organizationId: undefined, // ИД организациии
  segment: '', // Сегмент организации: "Малый бизнес", "Средний бизнес", "Крупный бизнес"
  role: '', // Роль уполномоченного лица: "ЕИО", "Сотрудник"
  organizations: undefined, // Общее количество организаций у уполномоченного лица: 1..300
  currentMethod: '', // Действующий способ подписания."SMS", "PayControl", "КЭП на токене", "КЭП в приложении"
  mobileApp: undefined, // Наличие мобильного приложения
  // Подписанные ранее типы документов
  common: {
    mobile: undefined, // Количество подписанных базовых документов в мобайле
    web: undefined, // Количество подписанных базовых документов в вебе
  },
  special: {
    mobile: undefined, // Количество подписанных документов особой важности в мобайле
    web: undefined, // Количество подписанных документов особой важности в вебе
  },
  availableMethods: [], // Уже подключенные способы подписания."SMS", "PayControl", "КЭП на токене", "КЭП в приложении"
  claims: undefined, // Наличие обращений в банк по причине проблем с использованием СМС
})

function add_user() {
  alert('Пока что функционал добавления пользователя доступен только на сервере')
}
</script>

<template>
  <div>
    <h1>Задайте имя и параметры нового пользователя</h1>
    <FloatLabel class="fl" variant="on">
      <InputNumber v-model="params.clientId" inputId="withoutgrouping" :useGrouping="false" fluid />
      <label for="on_label">clientId</label>
    </FloatLabel>

    <FloatLabel class="fl" variant="on">
      <InputNumber
        v-model="params.organizationId"
        inputId="withoutgrouping"
        :useGrouping="false"
        fluid
      />
      <label for="on_label">organizationId</label>
    </FloatLabel>

    <Select class="fl" v-model="params.segment" :options="segments" placeholder="segment" fluid />

    <Select class="fl" v-model="params.role" :options="roles" placeholder="role" fluid />

    <FloatLabel class="fl" variant="on">
      <InputNumber
        v-model="params.organizations"
        inputId="withoutgrouping"
        :useGrouping="false"
        fluid
      />
      <label for="on_label">organizations</label>
    </FloatLabel>

    <Select
      class="fl"
      v-model="params.currentMethod"
      :options="methods"
      placeholder="currentMethod"
      fluid
    />

    <div class="fl">
      <Checkbox v-model="params.mobileApp" inputId="mobileApp" binary />
      <label for="mobileApp">using mobileApp</label>
    </div>

    <FloatLabel class="fl" variant="on">
      <InputNumber
        v-model="params.common.mobile"
        inputId="withoutgrouping"
        :useGrouping="false"
        fluid
      />
      <label for="on_label">common.mobile</label>
    </FloatLabel>

    <FloatLabel class="fl" variant="on">
      <InputNumber
        v-model="params.common.web"
        inputId="withoutgrouping"
        :useGrouping="false"
        fluid
      />
      <label for="on_label">common.web</label>
    </FloatLabel>

    <FloatLabel class="fl" variant="on">
      <InputNumber
        v-model="params.special.mobile"
        inputId="withoutgrouping"
        :useGrouping="false"
        fluid
      />
      <label for="on_label">special.mobile</label>
    </FloatLabel>

    <FloatLabel class="fl" variant="on">
      <InputNumber
        v-model="params.special.web"
        inputId="withoutgrouping"
        :useGrouping="false"
        fluid
      />
      <label for="on_label">special.web</label>
    </FloatLabel>

    <SelectButton
      v-model="params.availableMethods"
      :options="methods"
      multiple
      aria-labelledby="multiple"
    />

    <FloatLabel class="fl" variant="on">
      <InputNumber v-model="params.claims" inputId="withoutgrouping" :useGrouping="false" fluid />
      <label for="on_label">claims</label>
    </FloatLabel>

    <Button
      class="btn"
      severity="contrast"
      label="Далее"
      @click="$emit('select-profile', params)"
    />
  </div>
</template>

<style scoped>
.fl {
  margin: 20px 0;
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
