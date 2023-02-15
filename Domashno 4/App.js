import './App.css';
import { BrowserRouter as Router, Switch,
    Route, Redirect,} from "react-router-dom";

import Home from "./Home"
import BankPage from "./BankPage"
import AtmPage from "./AtmPage";

function App() {
  return (
      <>
          <Router>
              <Switch>
                  <Route exact path="/" component={Home} />
                  <Route path="/bank" component={BankPage} />
                  <Route path="/atm" component={AtmPage} />
                  <Redirect to="/" />
              </Switch>
          </Router>
      </>
  );
}

export default App;
