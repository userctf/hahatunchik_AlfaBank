import App from './App.vue'

import { createApp } from 'vue'
import PrimeVue from 'primevue/config'
import Material from '@primevue/themes/material'
import ConfirmationService from 'primevue/confirmationservice'

const app = createApp(App)
app.use(PrimeVue, {
  theme: {
    preset: Material,
    options: {
      darkModeSelector: false || 'none',
    },
  },
})
app.use(ConfirmationService)

app.mount('#root')
