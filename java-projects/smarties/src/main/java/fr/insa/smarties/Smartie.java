package fr.insa.smarties;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Smartie extends Contract {
    private static final String BINARY = "6080604052604051610ea9380380610ea983398101604052805160208201519082019101600080808080610031610393565b600134116100a057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4e6f7420656e6f7567682077656920616464656420746f20636f6e7472616374604482015290519081900360640190fd5b87519550865194506000861180156100b85750600085115b80156100c357508486145b15156100cb57fe5b60009350600092505b848310156102cd57600091505b6001548210156101d35787838151811015156100f957fe5b90602001906020020151600160a060020a031660018381548110151561011b57fe5b6000918252602090912060029091020154600160a060020a031614156101c857604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152603560248201527f4572726f722c2074686520686569722068617320616c7265616479206265656e60448201527f206465636c6172656420696e207468652077696c6c0000000000000000000000606482015290519081900360840190fd5b6001909101906100e1565b604080519081016040528089858151811015156101ec57fe5b90602001906020020151600160a060020a03168152602001888581518110151561021257fe5b60209081029190910181015190915260018054808201825560009190915282517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf660029092029182018054600160a060020a031916600160a060020a03909216919091179055908201517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf79091015587519091508790849081106102b257fe5b906020019060200201518401935082806001019350506100d4565b6064841461036257604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602160248201527f546f74616c2070657263656e74616765206e6f7420657175616c20746f20313060448201527f3000000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b505060008054600160a060020a031916331781556005805460ff19169055600355505034600455506103aa92505050565b604080518082019091526000808252602082015290565b610af0806103b96000396000f3006080604052600436106100cf5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166314fae21881146100d45780631c0795c3146100fb578063252d3b7b146101365780633641a7b71461013e57806338cc4831146101555780635a58cd4c146101865780635eeddcaa1461019b5780636f92e149146101b0578063893d20e81461023a5780638bf3a17c1461024f57806399baa10c14610267578063a9c74a6614610290578063aedb1c8f146102a5578063c039c432146102ba575b600080fd5b3480156100e057600080fd5b506100e96102cf565b60408051918252519081900360200190f35b34801561010757600080fd5b506101136004356102d5565b60408051600160a060020a03909316835260208301919091528051918290030190f35b6100e961030b565b34801561014a57600080fd5b506101536103fb565b005b34801561016157600080fd5b5061016a610579565b60408051600160a060020a039092168252519081900360200190f35b34801561019257600080fd5b5061015361057d565b3480156101a757600080fd5b506100e961059e565b3480156101bc57600080fd5b506101c56105a4565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101ff5781810151838201526020016101e7565b50505050905090810190601f16801561022c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561024657600080fd5b5061016a610861565b34801561025b57600080fd5b506100e9600435610870565b34801561027357600080fd5b5061027c61099e565b604080519115158252519081900360200190f35b34801561029c57600080fd5b506100e96109a7565b3480156102b157600080fd5b506101536109ac565b3480156102c657600080fd5b506100e9610abe565b60065481565b60018054829081106102e357fe5b600091825260209091206002909102018054600190910154600160a060020a03909116915082565b60008054600160a060020a03163314610394576040805160e560020a62461bcd02815260206004820152602c60248201527f4f6e6c7920746865206f776e6572206f662074686520636f6e7472616374206360448201527f616e206164642065746865720000000000000000000000000000000000000000606482015290519081900360840190fd5b60013410156103ed576040805160e560020a62461bcd02815260206004820152601760248201527f4e6f7420656e6f756768207765692070726f7669646564000000000000000000604482015290519081900360640190fd5b506004805434019055303190565b60055460ff1615156104c9576040805160e560020a62461bcd02815260206004820152607360248201527f546865206f776e6572206973206e6f74206f6666696369616c6c79206465616460448201527f2e20486569727320726570726573656e74696e67206174206c6561737420383060648201527f25206f662074686520696e6865726974616e6365206e65656420746f2064656360848201527f6c61726520746865206f776e657220646561640000000000000000000000000060a482015290519081900360c40190fd5b60065442101561056f576040805160e560020a62461bcd02815260206004820152605760248201527f546865206c6174656e6379206e656564656420666f72207468652077696c6c2060448201527f746f20626520636c61696d6564206973206e6f7420796574207265616368656460648201527f2c20796f752077696c6c206861766520746f2077616974000000000000000000608482015290519081900360a40190fd5b6105776109ac565b565b3090565b600054600160a060020a031633141561057757600054600160a060020a0316ff5b60025490565b60606000805b6002548210156106615760028054339190849081106105c557fe5b600091825260209091200154600160a060020a03161415610656576040805160e560020a62461bcd02815260206004820152603360248201527f4572726f722c2074686520686569722068617320616c7265616479206465636c60448201527f6172656420746865206f776e6572206465616400000000000000000000000000606482015290519081900360840190fd5b6001909101906105aa565b5060005b60015481101561085c57600180543391908390811061068057fe5b6000918252602090912060029091020154600160a060020a031614156108545760018054829081106106ae57fe5b600091825260209091206002918202016001908101546003805490910190558054839081106106d957fe5b6000918252602080832060029092029091015483546001810185559383529120909101805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911790556003546050116107ca576005805460ff191660011790554260065560408051608081018252605381527f546865206f776e6572206973206f6666696369616c6c79206465636c6172656460208201527f20646561642c206120372064617973206c6174656e6379206973206e65656465918101919091527f6420746f20636c61696d207468652077696c6c000000000000000000000000006060820152925061085c565b608060405190810160405280605d81526020017f5468652068656972206f6666696369616c6c79206465636c617265642074686581526020017f206f776e657220646561642e204f746865722068656972732077696c6c206e6581526020017f656420746f206465636c61726520746865206f776e657220646561642e000000815250925061085c565b600101610665565b505090565b600054600160a060020a031690565b60008054600160a060020a031633146108f9576040805160e560020a62461bcd02815260206004820152602c60248201527f4f6e6c7920746865206f776e6572206f662074686520636f6e7472616374206360448201527f616e206164642065746865720000000000000000000000000000000000000000606482015290519081900360840190fd5b600454821115610953576040805160e560020a62461bcd02815260206004820152601e60248201527f4e6f7420656e6f7567682077656920696e2074686520636f6e74726163740000604482015290519081900360640190fd5b60048054839003905560008054604051600160a060020a039091169184156108fc02918591818181858888f19350505050158015610995573d6000803e3d6000fd5b50503031919050565b60055460ff1681565b303190565b6000805b600154811015610ab05760018054829081106109c857fe5b9060005260206000209060020201600101546004540291506064828115156109ec57fe5b0491506001818154811015156109fe57fe5b60009182526020822060029091020154604051600160a060020a039091169184156108fc02918591818181858888f19350505050158015610a43573d6000803e3d6000fd5b507fb9f6cc65b3b9b7dc18152bc517c1783d9a9d5039e42b72918de9bd1a4b40487c600182815481101515610a7457fe5b60009182526020918290206002909102015460408051600160a060020a03909216825291810185905281519081900390910190a16001016109b0565b600054600160a060020a0316ff5b600154905600a165627a7a72305820dcc0924d5857a0af42517581e179d63a86b205ca2df0fa1f4a6196676546cbec0029";

    public static final String FUNC_DEATHDATE = "deathDate";

    public static final String FUNC_HEIRS = "heirs";

    public static final String FUNC_ADDWEITOINHERITANCE = "addWeiToInheritance";

    public static final String FUNC_CLAIMWILL = "claimWill";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_DELETECONTRACT = "deleteContract";

    public static final String FUNC_GETNUMBEROFHEIRSTHATCLAIMEDWILL = "getNumberOfHeirsThatClaimedWill";

    public static final String FUNC_DECLAREDEAD = "declareDead";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_REMOVEWEIFROMINHERITANCE = "removeWeiFromInheritance";

    public static final String FUNC_ISDEAD = "isDead";

    public static final String FUNC_DISPLAYINHERITENCE = "displayInheritence";

    public static final String FUNC_EXECUTECONTRACT = "executeContract";

    public static final String FUNC_GETHEIRSNUMBER = "getHeirsNumber";

    public static final Event LOGCOINSSENT_EVENT = new Event("LogCoinsSent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LOGDEATH_EVENT = new Event("LogDeath", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    protected Smartie(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Smartie(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> deathDate() {
        final Function function = new Function(FUNC_DEATHDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<String, BigInteger>> heirs(BigInteger param0) {
        final Function function = new Function(FUNC_HEIRS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addWeiToInheritance(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ADDWEITOINHERITANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> claimWill() {
        final Function function = new Function(
                FUNC_CLAIMWILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getAddress() {
        final Function function = new Function(FUNC_GETADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> deleteContract() {
        final Function function = new Function(
                FUNC_DELETECONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getNumberOfHeirsThatClaimedWill() {
        final Function function = new Function(FUNC_GETNUMBEROFHEIRSTHATCLAIMEDWILL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> declareDead() {
        final Function function = new Function(
                FUNC_DECLAREDEAD, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> removeWeiFromInheritance(BigInteger valueToSubstract) {
        final Function function = new Function(
                FUNC_REMOVEWEIFROMINHERITANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(valueToSubstract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isDead() {
        final Function function = new Function(FUNC_ISDEAD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> displayInheritence() {
        final Function function = new Function(FUNC_DISPLAYINHERITENCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> executeContract() {
        final Function function = new Function(
                FUNC_EXECUTECONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getHeirsNumber() {
        final Function function = new Function(FUNC_GETHEIRSNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Smartie> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, List<String> _heirsAddr, List<BigInteger> _heirsPercentage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_heirsAddr, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_heirsPercentage, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Smartie.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<Smartie> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, List<String> _heirsAddr, List<BigInteger> _heirsPercentage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_heirsAddr, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_heirsPercentage, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Smartie.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public List<LogCoinsSentEventResponse> getLogCoinsSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGCOINSSENT_EVENT, transactionReceipt);
        ArrayList<LogCoinsSentEventResponse> responses = new ArrayList<LogCoinsSentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogCoinsSentEventResponse typedResponse = new LogCoinsSentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sentTo = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogCoinsSentEventResponse> logCoinsSentEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogCoinsSentEventResponse>() {
            @Override
            public LogCoinsSentEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGCOINSSENT_EVENT, log);
                LogCoinsSentEventResponse typedResponse = new LogCoinsSentEventResponse();
                typedResponse.log = log;
                typedResponse.sentTo = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogCoinsSentEventResponse> logCoinsSentEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGCOINSSENT_EVENT));
        return logCoinsSentEventObservable(filter);
    }

    public List<LogDeathEventResponse> getLogDeathEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGDEATH_EVENT, transactionReceipt);
        ArrayList<LogDeathEventResponse> responses = new ArrayList<LogDeathEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogDeathEventResponse typedResponse = new LogDeathEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.isDead = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.nbOfValid = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogDeathEventResponse> logDeathEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogDeathEventResponse>() {
            @Override
            public LogDeathEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGDEATH_EVENT, log);
                LogDeathEventResponse typedResponse = new LogDeathEventResponse();
                typedResponse.log = log;
                typedResponse.isDead = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.nbOfValid = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogDeathEventResponse> logDeathEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGDEATH_EVENT));
        return logDeathEventObservable(filter);
    }

    public static Smartie load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Smartie(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Smartie load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Smartie(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LogCoinsSentEventResponse {
        public Log log;

        public String sentTo;

        public BigInteger amount;
    }

    public static class LogDeathEventResponse {
        public Log log;

        public Boolean isDead;

        public BigInteger nbOfValid;
    }
}
