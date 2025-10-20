document.addEventListener("DOMContentLoaded", function () {
  var coinFilter = document.getElementById("coinFilter");
  var coinRows = document.querySelectorAll(".coinRow");

  coinFilter.addEventListener("input", function () {
    var filter = coinFilter.value.toUpperCase();
    coinRows.forEach(function (row) {
      // 抓 td 第一格全部文字
      var coinText = row.querySelector("td").textContent.toUpperCase();
      row.style.display = coinText.indexOf(filter) > -1 ? "" : "none";
    });
  });
});
