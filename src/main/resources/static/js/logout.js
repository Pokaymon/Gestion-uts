function logout() {
    if (confirm("¿Estás seguro de que quieres cerrar sesión?")) {
        fetch('/auth/logout', {
            method: 'POST',
            credentials: 'include'
        })
        .then(response => {
            if (response.ok) {
                window.location.href = '/';
            } else {
                alert('Error al cerrar sesión');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error de red al intentar cerrar sesión');
        });
    }
}
