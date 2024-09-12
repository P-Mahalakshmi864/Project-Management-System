const projectForm = document.getElementById('project-form');
const projectList = document.getElementById('project-list');

projectForm.addEventListener('submit', (e) => {
	e.preventDefault();
	const projectName = document.getElementById('project-name').value;
	fetch('/api/projects', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ name: projectName })
	})
	.then((response) => response.json())
	.then((data) => {
		const projectListItem = document.createElement('li');
		projectListItem.textContent = data.name;
		projectList.appendChild(projectListItem);
	});
});
