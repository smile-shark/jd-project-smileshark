import axios from '../axios_request'
import urls from './urls'
const ApiPlugin={
    install(app){
        app.config.globalProperties.$api={
            getHomeData:()=>{
                return axios.post(urls.homeData)
            },
            getHomeTitleData:()=>{
                return axios.post(urls.homeTitleData)
            },
            getDeliveryDataByGoodsId:(goodsId)=>{
                return axios.post(urls.deliveryDataByGoodsId,{
                    'goodsId':goodsId
                })
            },
            goodsComments:goodsId=>{
                return axios.post(urls.goodsComments,{
                    'goodsId':goodsId
                })
            },
            getSearchData:(pageNum,searchContent)=>{
                return axios.post(urls.searchContent,{
                    'pageNum':pageNum,
                    'searchContent':searchContent
                })
            },
            loginToPassword:(email,password)=>{
                return axios.post(urls.loginPassword,{
                    'email':email,
                    'password':password
                })
            },
            getEmail:()=>{
                return axios.post(urls.getEmail)
            },
            getShoppingCart:()=>{
                return axios.post(urls.getShoppingCart)
            },
            addGoodsToShoppingCart:goodsId=>{
                return axios.post(urls.addGoodsToShoppingCart,{
                    'goodsId':goodsId
                })
            }
        }
    }
}
export default ApiPlugin