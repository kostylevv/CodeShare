<script type="text/javascript">
        function appendAlert() {
            const wrapper = document.createElement('div')
            wrapper.innerHTML = [
                `<div class="alert alert-success alert-dismissible" role="alert">`,
                `   <div>Snippet added</div>`,
                '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
                '</div>'
            ].join('')
        const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
            alertPlaceholder.append(wrapper)
        }


        function send() {
            let object = {
                "code": document.getElementById("code_snippet").value
            };

            let json = JSON.stringify(object);

            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/code/new', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);

            if (xhr.status == 200) {
                appendAlert();
            }

        }
</script>