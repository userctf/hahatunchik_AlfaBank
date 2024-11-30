export async function sendPostRequest(path: string, data: any): Promise<any> {
  const url = `https://example.com/${path}`
  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`)
    }

    return await response.json()
  } catch (error) {
    console.error('Error:', error)
  }
}

export async function sendGetRequest(path: string, params: Record<string, any>): Promise<any> {
  const url = `https://example.com/${path}`
  const queryString = new URLSearchParams(params).toString()
  const fullUrl = `${url}?${queryString}`

  try {
    const response = await fetch(fullUrl)

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`)
    }

    return await response.json()
  } catch (error) {
    console.error('Error:', error)
  }
}
