document.addEventListener('DOMContentLoaded', function() {
    // Basic validation example
    const form = document.querySelector('#booking-form form');
    form.addEventListener('submit', function(event) {
        const name = form.querySelector('input[name="name"]').value;
        if (name === '') {
            alert('Please enter your name.');
            event.preventDefault(); // Prevent form from submitting
        }
        // Add more validations as needed
    });
});
