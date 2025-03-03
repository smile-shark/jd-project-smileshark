import axios from 'axios'
const instance=axios.create()
instance.interceptors.request.use(
    config=>{
        const token=localStorage.token
        if(token){
            config.headers['User-Token']=token
        }
        return config
    },
    error=>{
        return Promise.reject(error)
    }
)
export default instance;