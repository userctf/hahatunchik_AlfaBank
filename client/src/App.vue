<script setup lang="ts">
import ChooseProfile from './components/Choose_profile.vue'
import AddProfile from './components/Add_profile.vue'
import Choose_document_type from './components/Choose_document_type.vue'
import ChooseSignMethod from './components/Choose_sign_method.vue'

import SignSms from './components/Sign_sms.vue'
import { sendPostRequest } from './components/Base'

import { ref } from 'vue'

const data = ref({
  profile: '',
  document_type: '',
  sign_method: '',
  state: 'profile', // profile -> [add_profile] -> document_type -> sign_method
  token: '',
})

function add_profile(): any {
  // sendPostRequest("add_profile",   {"parameters": data})
  // .then(
  //   (response) => select_profile(response.name)
  // )

  data.value.state = 'add_profile'
}

function select_profile(profile: string): any {
  data.value.profile = profile

  data.value.state = 'document_type'
}

function select_document(doc_type: string) {
  data.value.document_type = doc_type

  data.value.state = 'sign_method'
}

function select_sign_method(method: string) {
  console.log(method)
  data.value.sign_method = method

  switch (method) {
  }
}

function step_back(step: string): any {
  switch (step) {
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

function check_sms_sign(code: string): any {
  console.log('code:', code)
}

const sign_methods = ['SMS', 'Token', 'RSA']
</script>

<template>
  <ChooseProfile
    v-if="data.state == 'profile'"
    @add-profile="add_profile"
    @select-profile="select_profile"
  />
  <AddProfile
    v-if="data.state == 'add_profile'"
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
    :sign_methods="sign_methods"
    @select-sign-method="select_sign_method"
    @step-back="step_back"
  />

  <SignSms
    v-if="data.state == 'sign_method_type'"
    :profile="data.profile"
    :document_type="data.document_type"
    @check-sms-sign="check_sms_sign"
    @step-back="step_back"
  />
</template>
