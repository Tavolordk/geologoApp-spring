// Utilizando const y let en lugar de var
let currentStep = 1;
let updateProgressBar;

// Utilizando una función de flecha
const displayStep = (stepNumber) => {
  if (stepNumber >= 1 && stepNumber <= 8) {
    document.querySelector(`.step-${currentStep}`).style.display = 'none';
    document.querySelector(`.step-${stepNumber}`).style.display = 'block';
    currentStep = stepNumber;
    updateProgressBar();
  }
};

document.addEventListener('DOMContentLoaded', () => {
  // Utilizando const y let en lugar de var
  const multiStepForm = document.getElementById('multi-step-form');
  const steps = Array.from(multiStepForm.querySelectorAll('.step'));

  steps.slice(1).forEach(step => {
    step.style.display = 'none';
  });

  // Utilizando funciones de flecha y const para declarar funciones
  const nextStepHandler = () => {
    if (currentStep < 8) {
      document.querySelector(`.step-${currentStep}`).classList.add('animate__animated', 'animate__fadeOutLeft');
      currentStep++;
      setTimeout(() => {
        steps.forEach(step => {
          step.classList.remove('animate__animated', 'animate__fadeOutLeft');
          step.style.display = 'none';
        });
        document.querySelector(`.step-${currentStep}`).style.display = 'block';
        document.querySelector(`.step-${currentStep}`).classList.add('animate__animated', 'animate__fadeInRight');
        updateProgressBar();
      }, 500);
    }
  };

  const prevStepHandler = () => {
    if (currentStep > 1) {
      document.querySelector(`.step-${currentStep}`).classList.add('animate__animated', 'animate__fadeOutRight');
      currentStep--;
      setTimeout(() => {
        steps.forEach(step => {
          step.classList.remove('animate__animated', 'animate__fadeOutRight');
          step.style.display = 'none';
        });
        document.querySelector(`.step-${currentStep}`).style.display = 'block';
        document.querySelector(`.step-${currentStep}`).classList.add('animate__animated', 'animate__fadeInLeft');
        updateProgressBar();
      }, 500);
    }
  };

  document.querySelector('.next-step').addEventListener('click', nextStepHandler);
  document.querySelector('.prev-step').addEventListener('click', prevStepHandler);

  updateProgressBar = () => {
    const progressPercentage = ((currentStep - 1) / 2) * 100;
    document.querySelector('.progress-bar').style.width = `${progressPercentage}%`;
  };
});
