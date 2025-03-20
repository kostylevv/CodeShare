<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript">
        function send() {
            let object = {
                "code": document.getElementById("code_snippet").value
            };

            let json = JSON.stringify(object);

            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/code/new', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);

        }
    </script>

    <title>Create</title>
</head>
<body>
<div class="d-flex justify-content-center">
    <div class="card">
        <div class="card-body">
            <label for="code_snippet"></label><textarea id="code_snippet"> ... </textarea>
            <button id="send_snippet" type="submit" onclick="send()">Submit</button>
        </div>
    </div>
</div>
</body>
</html>