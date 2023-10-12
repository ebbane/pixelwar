const socket = new WebSocket("ws://localhost:8080/pixelwar-websocket")

socket.onopen = function() {
  console.log("Connexion WebSocket établie");
};

socket.onmessage = function(event) {
  var message = event.data;
  console.log("Message reçu : " + message);
  drawPixels(JSON.parse(event.data));
};

socket.onclose = function() {
  console.log("Connexion WebSocket fermée");
};


function sendPixel(pixel) {
  var name = $("#name").val();
  if (name === null || name.trim() === "") {
    name = "anonymous"
  }
  const message = {
    x: pixel.x,
    y: pixel.y,
    color: pixel.color,
    user: name
  };
  socket.send(JSON.stringify(message));
}

let canvasContext;
let selectedColor = "red";

function drawPixels(pixels) {
  canvasContext.clearRect(0, 0, canvas.width, canvas.height);
  pixels.forEach(item => {
    canvasContext.fillStyle = item.color;
    canvasContext.fillRect(item.x, item.y, 1, 1);
  });
}

$(function () {
  $("form").on('submit', (e) => e.preventDefault());
});

function manageColorSelected(colorOptions) {
  colorOptions.forEach(option => {
    option.addEventListener("click", function () {
      selectedColor = option.getAttribute("data-color")
    });
  });
}

fetch('http://localhost:8080/pixel')
.then(response => {
  if (!response.ok) {
    throw new Error('Erreur HTTP : ' + response.status);
  }
  return response.json(); // Parse la réponse JSON
})
.then(data => {
  drawPixels(data);
})
.catch(error => {
  console.error('Erreur lors de la récupération des données : ', error);
});

class Pixel {
  constructor(x, y, color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }
}