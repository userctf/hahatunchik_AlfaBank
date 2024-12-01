from flask import Flask, request, jsonify
import keras
import numpy as np

app = Flask(__name__)

model = keras.models.load_model('rnn_model.h5')


@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    input_data = np.array(data['input']).reshape(1, -1)

    predictions = model.predict(input_data)

    return jsonify(predictions.tolist())


if __name__ == '__main__':
    app.run(debug=True)
