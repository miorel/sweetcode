// This snippet gives a bunch of problem paths from LeetCode.

Array.from(document.getElementsByTagName("a"))
  .filter(
    (a) =>
      a.getAttribute("href")?.startsWith("/problems/") &&
      /^(\d+)\. /.test(a.innerText.trim()),
  )
  .map(
    (a) =>
      a.innerText.split(".")[0].padStart(4, "0") +
      "-" +
      a
        .getAttribute("href")
        .replace(/^\/problems\//, "")
        .replace(/\/.*/, ""),
  )
  .sort();
