<script setup lang="ts">
import ChooseProfile from './components/Choose_profile.vue'
import AddProfile from './components/Add_profile.vue'
import Choose_document_type from './components/Choose_document_type.vue'
import ChooseSignMethod from './components/Choose_sign_method.vue'

import SignSms from './components/Sign_sms.vue'
import SignPasscode from './components/Sign_passcode.vue'
import { sendPostRequest } from './components/Base'

import ConfirmDialog from 'primevue/confirmdialog'
import { useConfirm } from 'primevue/useconfirm'
import { ref } from 'vue'

const confirm = useConfirm()

const show_result = (is_okey: boolean) => {
  confirm.require({
    message: is_okey ? 'Подпись удачно составлена!' : 'Возникла ошибка при подписи!',
    header: 'Результат',
    acceptProps: {
      label: 'Продолжить',
    },
    rejectProps: undefined,
    accept: () => {
      data.value.state = 'profile'
    },
  })
}

const data = ref({
  profile: undefined,
  document_type: 'Загрузка',
  sign_method: 'Загрузка',
  sign_methods: ['Загрузка'],
  state: 'profile', // profile -> [add_profile] -> document_type -> sign_method
  token: '',
})

function select_profile(profile: any) {
  data.value.profile = profile

  data.value.state = 'document_type'
}

function select_document(doc_type: string) {
  data.value.document_type = doc_type
  data.value.state = 'sign_method'

  sendPostRequest('get_sign_method', { profile: data.value.profile, document_type: doc_type }).then(
    (response) => {
      data.value.sign_methods = response.sign_method
    },
  )
}

// data.value.sign_methods = ['SMS', 'Token', 'RSA']
function select_sign_method(method: string) {
  sendPostRequest('select_method', { sign_method: method }).then((response) => {
    data.value.token = response.token
  })
  data.value.state = 'sign'
  data.value.sign_method = method
}

function step_back(step: string): any {
  switch (step) {
    case 'sign':
      data.value.state = 'sign_method'
      break
    case 'sign_method':
      data.value.state = 'document_type'
      break
    case 'document_type':
      data.value.state = 'profile'
      break
    case 'add_profile':
      data.value.state = 'profile'
      break
    default:
      throw new Error(`Can't step back. State: ${step}`)
  }
}

function check_sign(body: string): any {
  sendPostRequest('check_sign', { data: body }).then((response) => {
    show_result(response.status == 'ok')
  })
}
</script>

<template>
  <ConfirmDialog></ConfirmDialog>
  <!-- <ChooseProfile
    v-if="data.state == 'profile'"
    @add-profile="add_profile"
    @select-profile="select_profile"
  /> -->
  <AddProfile
    v-if="data.state == 'profile'"
    @select-profile="select_profile"
    @step-back="step_back"
  />

  <Choose_document_type
    v-if="data.state == 'document_type'"
    :profile="data.profile"
    @select-document="select_document"
    @step-back="step_back"
  />
  <ChooseSignMethod
    v-if="data.state == 'sign_method'"
    :profile="data.profile"
    :document_type="data.document_type"
    :sign_methods="data.sign_methods"
    @select-sign-method="select_sign_method"
    @step-back="step_back"
  />

  <SignSms
    v-if="data.state == 'sign' && data.sign_method == 'SMS'"
    :profile="data.profile"
    :document_type="data.document_type"
    @check-sign="check_sign"
    @step-back="step_back"
  />
  <SignPasscode
    v-if="data.state == 'sign' && data.sign_method != 'SMS'"
    :profile="data.profile"
    :document_type="data.document_type"
    @check-sign="check_sign"
    @step-back="step_back"
  />
</template>
