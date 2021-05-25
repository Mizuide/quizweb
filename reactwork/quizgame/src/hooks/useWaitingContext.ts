import { useContext } from "react";
import { waitingContext } from "../App";

const useWaitingContext = <T>(executor:Promise<T>) =>{
    const [,setWaiting] = useContext(waitingContext)
    const startWaiting = new Promise(resolve =>{
        setWaiting(true);
        resolve(true);
    });
    Promise.all([startWaiting,executor]).then(() => setWaiting(false));
}

export default useWaitingContext;