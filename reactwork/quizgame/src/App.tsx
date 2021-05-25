import './App.css';
import { createContext, useState } from 'react'
import QuizScreen from './component/QuizScreen';
import {
  BrowserRouter as Router,
  Route,
  Switch
} from 'react-router-dom'
import QuizIndex from './component/QuizIndex';


const [waiting, setWaiting] = useState<boolean>(false);
type waitingContext = [boolean,React.Dispatch<React.SetStateAction<boolean>>]


export const waitingContext = createContext<waitingContext>([waiting,setWaiting]);

function App() {
  const display = waiting?'none':'block';
  
  return (
    <waitingContext.Provider value={[waiting,setWaiting]}>
      <div style={{display:display}}>
      <Router basename='/quizWeb/react'>
        <Switch>
          <Route exact path='/'>
            <QuizIndex />
          </Route>
          <Route exact path='/game/:id' >
            <QuizScreen />
          </Route>
        </Switch>
      </Router>
  </div>
    </waitingContext.Provider>
  );
}

export default App;
