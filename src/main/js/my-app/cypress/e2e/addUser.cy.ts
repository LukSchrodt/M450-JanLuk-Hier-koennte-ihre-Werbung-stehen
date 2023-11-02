import user from "../fixtures/user.json";

const { nameOne,emailOne } = user.userOne;
const { nameTwo,emailTwo } = user.userTwo;

beforeEach(() => {
  cy.restoreLocalStorage();
});

afterEach(() => {
  cy.saveLocalStorage();
});

describe('Visit the Website then click to add a user and fill in the credentials and click add', () => {
  it('Add a user', () => {
    console.log(nameOne)
    cy.visit('/')
    cy.getElement("addStudent").click()
    cy.fillForm(nameOne,emailOne)
  })


  it('Add a second user', () => {
    cy.visit('/addstudents')
    cy.fillForm(nameTwo,emailTwo)
  })
})
